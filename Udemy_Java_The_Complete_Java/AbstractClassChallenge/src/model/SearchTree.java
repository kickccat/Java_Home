package model;

public class SearchTree implements NodeList {

    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if (this.root == null) {
            this.root = item;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparision = currentItem.compareTo(item);
            if (comparision < 0) {
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    currentItem.setNext(item);
                    return true;
                }
            } else if (comparision > 0) {
                if (currentItem.previous() != null) {
                    currentItem = currentItem.previous();
                } else {
                    currentItem.setPrevious(item);
                    return true;
                }
            } else {
                System.out.println(item.getValue() + " is already present");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }

        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;
        while (currentItem != null) {
            int comparision = currentItem.compareTo(item);
            if (comparision < 0) {
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if (comparision > 0) {
                parentItem = currentItem;
                currentItem = currentItem.previous();
            } else {
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }

    private void performRemoval(ListItem currentItem, ListItem parentItem) {
        if (currentItem.next() == null) {
            if (parentItem.next() == currentItem) {
                parentItem.setNext(currentItem.previous());
            } else if (parentItem.previous() == currentItem) {
                parentItem.setPrevious(currentItem.previous());
            } else {
                this.root = currentItem.previous();
            }
        } else if (currentItem.previous() == null) {
            if (parentItem.next() == currentItem) {
                parentItem.setNext(currentItem.next());
            } else if (parentItem.previous() == currentItem) {
                parentItem.setPrevious(currentItem.next());
            } else {
                this.root = currentItem.next();
            }
        } else {
            ListItem pointed = currentItem.next();
            ListItem leftmostParent = currentItem;
            while (pointed.previous() != null) {
                leftmostParent = pointed;
                pointed = pointed.previous();
            }
            currentItem.setValue(pointed.getValue());
            if (leftmostParent == currentItem) {
                currentItem.setNext(pointed.next());
            } else {
                leftmostParent.setPrevious(pointed.next());
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        if (root != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }
}
