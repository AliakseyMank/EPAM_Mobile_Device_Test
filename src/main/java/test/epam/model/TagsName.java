package test.epam.model;

public enum TagsName {
    SMARTPHONE("smartphone"),
    READER("reader"),
    NOTEBOOK("notebook"),
    DESKTOP_COMPUTER("desktopComputer")
    ;

    private final String tag;

    TagsName(String tag) {
        this.tag = tag;

    }

    public String getTag(){
        return tag;
    }


}
