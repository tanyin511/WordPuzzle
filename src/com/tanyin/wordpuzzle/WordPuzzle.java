package com.tanyin.wordpuzzle;

import java.util.ArrayList;

/**
 * Created by tanyin on 2017/1/7.
 */
public class WordPuzzle {
    public static final int MAX_WORD_SIZE = 16;
    ArrayList<String> mWordList = new ArrayList<String>();
    ArrayList<Step> mSteps = new ArrayList<Step>();

    private static final int rowSize = 5;
    private static final int ColumnSize = 5;

    public WordPuzzle() {
        mWordList.add(mWordList.size(), "ddddd");
        mWordList.add(mWordList.size(), "aaaaa");
        mWordList.add(mWordList.size(), "ccccc");
        mWordList.add(mWordList.size(), "bbbbb");
        mWordList.add(mWordList.size(), "eeeee");
        mWordList.add(mWordList.size(), "abcde");

        //mSteps.add(new Step(0, 0, Step.RIGHT));
        //mSteps.add(new Step(10, 0, Step.DOWN_RIGHT));
    }

    public void run() {

        boolean rslt = placeOneWord(0);
        System.out.println("reslt is " + rslt);

        Board mBoard = new Board(rowSize, ColumnSize);
        mBoard.setBoardState(mWordList, mSteps);
        mBoard.showBoard();

        if (rslt) {
            for (int i = 0; i < mWordList.size(); i++) {
                System.out.println(mWordList.get(i) + ":"
                        + mSteps.get(i).getX() + " " + mSteps.get(i).getY() + " " + mSteps.get(i).getDir());
            }
        }
    }

    /*放置第i个单词到表格中*/
    private boolean placeOneWord(int number) {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < ColumnSize; j++) {
                /*循环放置八个方向*/
                for (int k = 0; k < 8; k++) {
                    Board mBoard = new Board(rowSize, ColumnSize);
                    mBoard.setBoardState(mWordList, mSteps);

                    if (mBoard.placeWord(mWordList.get(number), new Step(i, j, k))) {
                        mSteps.add(mSteps.size(), new Step(i, j, k));
                        /*放置完成全部单词，返回成功*/
                        if (number == mWordList.size() - 1) {
                            return true;
                        }
                        /*如果放置后续的单词返回成功，则返回成功，否则继续尝试别的放法*/
                        if (placeOneWord(number + 1)) {
                            return true;
                        }
                    }
                }
            }
        }
        int size = mSteps.size();
        mSteps.remove(size - 1);
        return false;
    }
}
