package translation;

import translation.functions.TranslationFunction;
import visualtization.PixelData;

public final class PixelDataTranslatorFacade {

    public static PixelData[][] translate(long[][] matrix, TranslationFunction function) {
        PixelDataTranslator translator = new PixelDataTranslator(matrix, function);

        startLogger();
        PixelData[][] data = translator.doTranslate();
        stopLogger();

        return data;
    }

    private static void startLogger() {
        // TODO Auto-generated method stub
    }

    private static void stopLogger() {
        // TODO Auto-generated method stub
    }


}
