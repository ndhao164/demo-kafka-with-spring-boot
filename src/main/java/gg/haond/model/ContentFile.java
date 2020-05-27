package gg.haond.model;

import java.io.File;

public class ContentFile {
    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public ContentFile(File file) {
        super();
        this.file = file;
    }

    public ContentFile() {
        super();
    }

}
