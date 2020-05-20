package org.primefaces.showcase.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.enterprise.inject.spi.CDI;

import javax.faces.application.ProjectStage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIPanel;
import javax.faces.context.FacesContext;

import org.primefaces.cache.CacheProvider;
import org.primefaces.component.tabview.Tab;

public class ShowcaseUtil {

    public static final List<FileContent> getFilesContent(String fullPath, Boolean readBeans) {
        CacheProvider provider = CDI.current().select(ShowcaseCacheProvider.class).get().getCacheProvider();
        List<FileContent> files = (List<FileContent>) provider.get("contents", fullPath);

        if (files == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FileContent srcContent = getFileContent(fullPath, readBeans);
            UIComponent tabs = UIComponent.getCurrentComponent(facesContext).getFacet("static-tabs");
            if (tabs != null) {
                attach(tabs, srcContent);
            }
            files = new ArrayList<>();
            flatFileContent(srcContent, files);

            if (facesContext.isProjectStage(ProjectStage.Production)) {
                provider.put("contents", fullPath, files);
            }
        }
        return files;
    }

    // EXCLUDE-SOURCE-START
    private static final FileContent getFileContent(String fullPath, Boolean readBeans) {
        try {
            // Finding in WEB ...
            FacesContext fc = FacesContext.getCurrentInstance();
            InputStream is = fc.getExternalContext().getResourceAsStream(fullPath);
            if (is != null) {
                return FileContentMarkerUtil.readFileContent(fullPath, is, readBeans);
            }

            // Finding in ClassPath ...
            is = ShowcaseUtil.class.getResourceAsStream(fullPath);
            if (is != null) {
                return FileContentMarkerUtil.readFileContent(fullPath, is, readBeans);
            }
        } catch (Exception e) {
            throw new IllegalStateException("Internal error: file " + fullPath + " could not be read", e);
        }

        return null;
    }

    private static void attach(UIComponent component, FileContent file) {
        if (component.isRendered()) {
            if (component instanceof Tab) {
                String flatten = (String) component.getAttributes().get("flatten");
                FileContent content = getFileContent(
                        ((Tab) component).getTitle(),
                        flatten == null ? false : Boolean.valueOf(flatten));
                file.getAttached().add(content);
            }
            else if (component instanceof UIPanel) {
                for (UIComponent child : component.getChildren()) {
                    attach(child, file);
                }
            }
        }
    }

    private static void flatFileContent(FileContent source, List<FileContent> dest) {
        dest.add(new FileContent(source.getTitle(), source.getValue(), source.getType(), Collections.<FileContent>emptyList()));

        for(FileContent file : source.getAttached()) {
            flatFileContent(file, dest);
        }
    }
    // EXCLUDE-SOURCE-END
}