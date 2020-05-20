/*
 * Copyright 2009-2020 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.showcase.view.data.tree;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

public class LazyLoadingTreeNode extends DefaultTreeNode {

    private Function<String, List<FileInfo>> loadFunction;
    private boolean lazyLoaded;

    public LazyLoadingTreeNode(FileInfo data, Function<String, List<FileInfo>> loadFunction) {
        super(data);
        this.loadFunction = loadFunction;
    }

    @Override
    public List<TreeNode> getChildren() {
        lazyLoad();
        
        return super.getChildren();
    }

    @Override
    public int getChildCount() {
        lazyLoad();
        
        return super.getChildCount();
    }

    @Override
    public boolean isLeaf() {
        lazyLoad();

        return super.isLeaf();
    }

    private void lazyLoad() {
        if (!lazyLoaded) {
            lazyLoaded = true;

            String parentId = ((FileInfo) getData()).getPath();
            System.out.println("Lazy load: " + parentId);
            List<LazyLoadingTreeNode> childNodes = loadFunction.apply(parentId).stream()
                    .map(f -> new LazyLoadingTreeNode(f, loadFunction)).collect(Collectors.toList());
            super.getChildren().addAll(childNodes);
        }
    }
}
