package org.primefaces.showcase.util;

import java.io.Serializable;
import java.util.List;

/**
 * FileContentMarkerUtil
 *
 * @author Sébastien Lepage / last modified by $Author$
 * @version $Revision$
 * @since 6.3
 */
public class FileContent implements Serializable {

    private final String title;

    private final String value;

    private final String type;

    private final List<FileContent> attached;

    public FileContent(String title, String value, String type, List<FileContent> attached) {
        this.title = title;
        this.value = value;
        this.type = type;
        this.attached = attached;
    }

    public String getTitle() {
        return title;
    }

    public String getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public List<FileContent> getAttached() {
        return attached;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FileContent other = (FileContent) obj;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return value;
    }

}