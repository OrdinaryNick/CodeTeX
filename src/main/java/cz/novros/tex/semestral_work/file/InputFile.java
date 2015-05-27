package cz.novros.tex.semestral_work.file;

/**
 * LICENSE This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details at
 * http://www.gnu.org/copyleft/gpl.html
 **/

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class for reading file.
 *
 * @author Rostislav Novak <rostislav.novak92@gmail.com>
 * @version 1.0
 * @since 2015-05-27
 */
public class InputFile {
    Logger logger = Logger.getLogger("InputFile");
    final static Charset ENCODING = StandardCharsets.UTF_8;

    private String fileName = "";
    private Path path;
    private BufferedReader reader = null;
    private boolean end = false;

    public InputFile(String fileName) throws IOException {
        logger.debug("Openning file in constructor...");
        this.fileName = fileName;
        this.path = Paths.get(this.fileName);
        reader = Files.newBufferedReader(path, ENCODING);
    }

    /**
     * Read one line from file.
     *
     * @return String filled with one line.
     */
    public String readLine() {
        logger.debug("Reading line. End=" + end);
        String line = null;

        try {
            if (!end) {
                line = reader.readLine();
            }
        } catch (IOException e) {
            logger.error("Could not read line. " + e);
            e.printStackTrace();
        }

        if(line == null) {
            end = true;
            return "";
        }

        return line;
    }

    public boolean isEnd() {
        return end;
    }
}