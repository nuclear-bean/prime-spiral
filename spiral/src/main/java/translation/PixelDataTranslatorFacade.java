package translation;

import lombok.extern.log4j.Log4j2;
import translation.functions.TranslationFunction;
import visualtization.PixelData;

/**
 * Facade class to provide static access to PixelDataTranslator.doTranslate function.
 */
@Log4j2
public final class PixelDataTranslatorFacade {

    public static PixelData[][] translate(long[][] matrix, TranslationFunction function) {
        log.info("Starting translation");
        PixelDataTranslator translator = new PixelDataTranslator(matrix, function);
        BasicPDTLogger logger = new BasicPDTLogger(matrix.length, translator);
        logger.start();

        PixelData[][] data = translator.doTranslate();

        logger.interrupt();
        log.info("Translation finished");

        return data;
    }
}
