package ui;

import util.ConsoleUIHelper;

public abstract class BasicUI {
    protected static final int DEFAULT_COLUMNS = 120;
    protected static final int DEFAULT_ROWS = 24;
    protected int columns;
    protected int rows;
    protected String pageTitle;

    public BasicUI(String pageTitle){
        this(DEFAULT_COLUMNS,DEFAULT_ROWS,pageTitle);
    }

    public BasicUI(int columns, int rows, String pageTitle){
        this.columns = columns;
        this.rows = rows;
        this.pageTitle = pageTitle;
    }

    public void show(){
        do {
            ConsoleUIHelper.drawHeader(pageTitle,columns);
            int linesUsed = 3+drawContent() + menuLines();

            ConsoleUIHelper.fillVSpace(rows - linesUsed, columns);
            ConsoleUIHelper.drawLine(columns);
            if(!drawMenu()) {
                break;
            }
        } while(true);
    }

    public abstract int drawContent();

    public abstract int menuLines();

    public abstract boolean drawMenu();
}
