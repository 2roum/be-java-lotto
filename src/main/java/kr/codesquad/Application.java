package kr.codesquad;

import kr.codesquad.controller.LottoGameController;

public class Application {
    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController();
        lottoGameController.play();
    }
}