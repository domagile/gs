package googlesheets.model.text.add;

import googlesheets.model.mergevalues.MergeValuesOptionBuilder;

public class AddTextOptionBuilder {
    private String range;
    private String addedText;
    private PositionEnumeration position;
    private int characterNumber;
    private String positionText;
    private boolean skipEmptyCells;

    public AddTextOptionBuilder range(String range) {
        this.range = range;
        return this;
    }


    public AddTextOptionBuilder addedText(String addedText) {
        this.addedText = addedText;
        return this;
    }

    public AddTextOptionBuilder position(PositionEnumeration position) {
        this.position = position;
        return this;
    }

    public AddTextOptionBuilder characterNumber(int characterNumber) {
        this.characterNumber = characterNumber;
        return this;
    }

    public AddTextOptionBuilder positionText(String positionText) {
        this.positionText = positionText;
        return this;
    }

    public AddTextOptionBuilder skipEmptyCells(boolean skipEmptyCells) {
        this.skipEmptyCells = skipEmptyCells;
        return this;
    }

    public AddTextOptions build()
    {
        AddTextOptions options = new AddTextOptions();
        options.setRange(range);
        options.setAddedText(addedText);
        options.setPosition(position);
        options.setCharacterNumber(characterNumber);
        options.setPositionText(positionText);
        options.setSkipEmptyCells(skipEmptyCells);
        return options;
    }
}
