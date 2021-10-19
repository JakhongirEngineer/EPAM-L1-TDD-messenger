package com.epam.ld.module2.testing.drivers;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@EnabledOnOs({OS.WINDOWS, OS.LINUX, OS.MAC})
@EnabledForJreRange(min = JRE.JAVA_9)
class FileDriverTest {

    @DisplayName("invalid file names provided:")
    @Tag("invalid_filename")
    @Test
    void whenOnFileModeInvalidFilenamesAreProvidedThrowsAnException()  {
        Scanner scanner = mock(Scanner.class);
        when(scanner.nextLine()).thenReturn("ThereIsNotSuchFileNameSoItShouldThrowAnException").thenReturn("no_input_file");
        FileDriver fileDriver = new FileDriver(scanner);
        assertThrows(RuntimeException.class, fileDriver::run);
    }
}