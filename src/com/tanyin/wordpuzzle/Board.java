package com.tanyin.wordpuzzle;

import java.util.ArrayList;

/**
 * Created by tanyin on 2017/1/7.
 */
public class Board {
    int[][] mBoard;
    int mRow;
    int mColumn;

    public Board(int row, int column) {
        mBoard = new int[row][column];
        mRow = row;
        mColumn = column;
    }

    public void setBoardState(ArrayList<String> words, ArrayList<Step> steps) {
        resetBoard();

        for (int i = 0; i < steps.size(); i++) {
            placeWord(words.get(i), steps.get(i));
        }
    }

    public boolean placeWord(String s, Step step) {

        /*检查是否单词可以合法放下*/
        for (int i = 0; i < s.length(); i++) {
            int row = getRow(step.getX(), step.getDir(), i);
            int column = getColumn(step.getY(), step.getDir(), i);
            if (isIllegal(row, column, s.charAt(i))) {
                return false;
            }
        }

        /*放置这个单词到当前表格*/
        for (int i = 0; i < s.length(); i++) {
            int row = getRow(step.getX(), step.getDir(), i);
            int column = getColumn(step.getY(), step.getDir(), i);
            mBoard[row][column] = s.charAt(i);
        }

        return true;
    }


    private int getColumn(int y, int dir, int i) {
        int rslt = -1;
        switch (dir) {
            case Step.RIGHT:
                rslt = y + i;
                break;
            case Step.UP_RIGHT:
                rslt = y + i;
                break;
            case Step.UP:
                rslt = y;
                break;
            case Step.UP_LEFT:
                rslt = y - i;
                break;
            case Step.LEFT:
                rslt = y - i;
                break;
            case Step.DOWN_LEFT:
                rslt = y - i;
                break;
            case Step.DOWN:
                rslt = y;
                break;
            case Step.DOWN_RIGHT:
                rslt = y + i;
                break;
        }
        return rslt;
    }

    private int getRow(int x, int dir, int i) {
        int rslt = -1;
        switch (dir) {
            case Step.RIGHT:
                rslt = x;
                break;
            case Step.UP_RIGHT:
                rslt = x - i;
                break;
            case Step.UP:
                rslt = x - i;
                break;
            case Step.UP_LEFT:
                rslt = x - i;
                break;
            case Step.LEFT:
                rslt = x;
                break;
            case Step.DOWN_LEFT:
                rslt = x + i;
                break;
            case Step.DOWN:
                rslt = x + i;
                break;
            case Step.DOWN_RIGHT:
                rslt = x + i;
                break;
        }
        return rslt;
    }

    private boolean isIllegal(int row, int column, int c) {
        if (row < 0 || row >= mRow) {
            return true;
        }
        if (column < 0 || column >= mColumn) {
            return true;
        }
        if ((mBoard[row][column] != 0)
                && (mBoard[row][column] != c)) {
            return true;
        }
        return false;
    }

    private void resetBoard() {
        for (int i = 0; i < mRow; i++) {
            for (int j = 0; j < mColumn; j++) {
                mBoard[i][j] = 0;
            }
        }
    }

    public void showBoard() {
        for (int i = 0; i < mRow; i++) {
            for (int j = 0; j < mColumn; j++) {
                if (mBoard[i][j] == 0) {
                    System.out.printf("- ");
                } else {
                    System.out.printf("%c ", mBoard[i][j]);
                }
            }
            System.out.println();
        }
    }
}
