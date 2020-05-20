package org.primefaces.showcase.util;

/**
 * FileContentSettings
 *
 * @author Sébastien Lepage / last modified by $Author$
 * @version $Revision$
 * @since 6.3
 */
public class FileContentSettings {

    private Marker[] startMarkers = null;
    private Marker[] endMarkers = null;
    private String type;

    public Marker[] getStartMarkers() {
        if (startMarkers == null) {
            return new Marker[0];
        }
        return startMarkers;
    }

    public FileContentSettings setStartMarkers(Marker... startMarkers) {
        this.startMarkers = startMarkers;
        return this;
    }

    public Marker[] getEndMarkers() {
        if (endMarkers == null) {
            return new Marker[0];
        }
        return endMarkers;
    }

    public FileContentSettings setEndMarkers(Marker... endMarkers) {
        this.endMarkers = endMarkers;
        return this;
    }

    public String getType() {
        return type;
    }

    public FileContentSettings setType(String type) {
        this.type = type;
        return this;
    }
}
