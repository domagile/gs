package googlesheets.model.text.add;

public class AddTextOptions {
    private String range;
    private String addedText;
    private PositionEnumeration position;
    private int characterNumber;
    private String positionText;
    private boolean skipEmptyCells;


    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getAddedText() {
        return addedText;
    }

    public void setAddedText(String addedText) {
        this.addedText = addedText;
    }

    public PositionEnumeration getPosition() {
        return position;
    }

    public void setPosition(PositionEnumeration position) {
        this.position = position;
    }

    public int getCharacterNumber() {
        return characterNumber;
    }

    public void setCharacterNumber(int characterNumber) {
        this.characterNumber = characterNumber;
    }

    public String getPositionText() {
        return positionText;
    }

    public void setPositionText(String positionText) {
        this.positionText = positionText;
    }

    public boolean isSkipEmptyCells() {
        return skipEmptyCells;
    }

    public void setSkipEmptyCells(boolean skipEmptyCells) {
        this.skipEmptyCells = skipEmptyCells;
    }
}
