package cz.novros.tex.semestral_work.processing;

/**
 * Created by rostislav on 27.5.15.
 */
public interface IProcessor {

    public void loadLanguageConfiguration(String programmingLanguage);
    public String processLine(String line);
}
