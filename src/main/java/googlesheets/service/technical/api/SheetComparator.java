package googlesheets.service.technical.api;

import com.google.api.services.sheets.v4.model.*;

import java.util.ArrayList;
import java.util.List;

public class SheetComparator {
    private List<String> diffs = new ArrayList<>();
    private CellReference cellReference;

    public List<String> compare(Sheet sheet1, Sheet sheet2) {
        compareProperties(sheet1.getProperties(), sheet2.getProperties());
        compareData(sheet1.getData(), sheet2.getData());
        return diffs;
    }

    private void compareData(List<GridData> dataList1, List<GridData> dataList2) {
        GridData gridData1 = dataList1.get(0);
        GridData gridData2 = dataList2.get(0);
        List<RowData> rowData1 = gridData1.getRowData();
        List<RowData> rowData2 = gridData2.getRowData();
        for (int i = 0; i < rowData1.size(); i++) {
            compareRowData(rowData1.get(i), rowData2.get(i), i);
        }
    }


    private void compareRowData(RowData rowData1, RowData rowData2, int rowIndex) {
        List<CellData> cellList1 = rowData1.getValues();
        List<CellData> cellList2 = rowData2.getValues();
        if (checkNull(cellList1, cellList2, "Cell list for row " + rowIndex) ||
                !isSizeEqual(cellList1, cellList2, "Different number of cells for row " + rowIndex)) {
            return;
        }
        for (int i = 0; i < cellList1.size(); i++) {
            compareCellData(cellList1.get(i), cellList2.get(i), new CellReference(rowIndex, i));
        }
    }

    private void compareCellData(CellData cellData1, CellData cellData2, CellReference cellReference) {
        this.cellReference = cellReference;
        compareFormat(cellData1.getEffectiveFormat(), cellData2.getEffectiveFormat());
        compareValues(cellData1.getFormattedValue(), cellData2.getFormattedValue(), "Formatted value");
        compareValues(cellData1.getHyperlink(), cellData2.getHyperlink(), "Hyperlink");
        compareValues(cellData1.getNote(), cellData2.getNote(), "Note");
        this.cellReference = null;
    }

    private void compareFormat(CellFormat format1, CellFormat format2) {
        if (checkNull(format1, format2, "Format")) {
            return;
        }
        compareTextFormat(format1.getTextFormat(), format2.getTextFormat());
        compareNumberFormat(format1.getNumberFormat(), format2.getNumberFormat());
        compareBorders(format1.getBorders(), format2.getBorders());
        comparePadding(format1.getPadding(), format2.getPadding());
        compareValues(format1.getBackgroundColor(), format2.getBackgroundColor(), "Background color");
        compareValues(format1.getHorizontalAlignment(), format2.getHorizontalAlignment(), "Horizontal alignment");
        compareValues(format1.getVerticalAlignment(), format2.getVerticalAlignment(), "Vertical alignment");
        compareValues(format1.getHyperlinkDisplayType(), format2.getHyperlinkDisplayType(), "Hyperlink display type");
        compareValues(format1.getTextDirection(), format2.getTextDirection(), "Text direction");
        compareValues(format1.getWrapStrategy(), format2.getWrapStrategy(), "Wrap strategy");
        compareTextRotation(format1.getTextRotation(), format2.getTextRotation());
    }

    private void compareTextRotation(TextRotation textRotation1, TextRotation textRotation2) {
        if (checkNull(textRotation1, textRotation2, "Text rotation")) {
            return;
        }
        compareValues(textRotation1.getAngle(), textRotation2.getAngle(), "Text rotation angle");
        compareValues(textRotation1.getVertical(), textRotation2.getVertical(), "Text rotation vertical");
    }

    private void comparePadding(Padding padding1, Padding padding2) {
        compareValues(padding1.getBottom(), padding2.getBottom(), "Bottom padding");
        compareValues(padding1.getTop(), padding2.getTop(), "Top padding");
        compareValues(padding1.getLeft(), padding2.getLeft(), "Left padding");
        compareValues(padding1.getRight(), padding2.getRight(), "Right padding");
    }

    private void compareBorders(Borders borders1, Borders borders2) {
        if (checkNull(borders1, borders2, "Borders")) {
            return;
        }
        compareBorder(borders1.getBottom(), borders2.getBottom());
        compareBorder(borders1.getLeft(), borders2.getLeft());
        compareBorder(borders1.getRight(), borders2.getRight());
        compareBorder(borders1.getTop(), borders2.getTop());
    }

    private void compareBorder(Border border1, Border border2) {
        compareValues(border1.getColor(), border2.getColor(), "Border color");
        compareValues(border1.getStyle(), border2.getStyle(), "Border style");
        compareValues(border1.getWidth(), border2.getWidth(), "Border width");
    }

    private void compareNumberFormat(NumberFormat numberFormat1, NumberFormat numberFormat2) {
        if (checkNull(numberFormat1, numberFormat2, "Number format")) {
            return;
        }
        compareValues(numberFormat1.getPattern(), numberFormat2.getPattern(), "Pattern");
        compareValues(numberFormat1.getType(), numberFormat2.getType(), "Number format type");
    }

    private void compareTextFormat(TextFormat textFormat1, TextFormat textFormat2) {
        compareValues(textFormat1.getBold(), textFormat2.getBold(), "Bold");
        compareValues(textFormat1.getItalic(), textFormat2.getItalic(), "Italic");
        compareValues(textFormat1.getFontFamily(), textFormat2.getFontFamily(), "Font family");
        compareValues(textFormat1.getFontSize(), textFormat2.getFontSize(), "Font size");
        compareValues(textFormat1.getForegroundColor(), textFormat2.getForegroundColor(), "Foreground color");
        compareValues(textFormat1.getStrikethrough(), textFormat2.getStrikethrough(), "Strikethrough");
        compareValues(textFormat1.getUnderline(), textFormat2.getUnderline(), "Underline");
    }


    private void compareProperties(SheetProperties properties1, SheetProperties properties2) {
        compareGridProperties(properties1.getGridProperties(), properties2.getGridProperties());
        compareValues(properties1.getSheetType(), properties2.getSheetType(), "Sheet type");
    }


    private void compareGridProperties(GridProperties gridProperties1, GridProperties gridProperties2) {
        compareValues(gridProperties1.getColumnCount(), gridProperties2.getColumnCount(), "Column count");
        compareValues(gridProperties1.getFrozenColumnCount(), gridProperties2.getFrozenColumnCount(), "Frozen column count");
        compareValues(gridProperties1.getRowCount(), gridProperties2.getRowCount(), "Row count");
        compareValues(gridProperties1.getFrozenRowCount(), gridProperties2.getFrozenRowCount(), "Frozen row count");
    }


    private boolean checkNull(Object value1, Object value2, String message) {
        if (value1 == null || value2 == null) {
            if (value1 != value2) {
                diffs.add((cellReference == null ? "" : cellReference + "\n") + message + "\nActual value: " + value1 + "\nExpected value: " + value2);
            }
            return true;
        }
        return false;
    }


    private boolean isSizeEqual(List<?> list1, List<?> list2, String message) {
        if (list1.size() != list2.size()) {
            diffs.add((cellReference == null ? "" : cellReference + "\n") + message + "\nActual value: " + list1.size() + "\nExpected value: " + list2.size());
            return false;
        }
        return true;
    }


    private void compareValues(Object value1, Object value2, String message) {
        if (value1 == null && value2 != null ||
                value1 != null && !value1.equals(value2)) {
            diffs.add((cellReference == null ? "" : cellReference + "\n") + message + "\nActual value: " + value1 + "\nExpected value: " + value2);
        }
    }


    private static class CellReference
    {
        private int row;
        private int cell;

        CellReference(int row, int cell) {
            this.row = row;
            this.cell = cell;
        }


        private String cellName(int zeroBasedIndex) {
            return zeroBasedIndex < 0 ? "" : cellName(zeroBasedIndex / 26 - 1) + (char) (zeroBasedIndex % 26 + 65);
        }


        @Override
        public String toString() {
            return String.format("Cell: %s%d", cellName(cell), row + 1);
        }
    }
}
