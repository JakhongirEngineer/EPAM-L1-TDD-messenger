package com.epam.ld.module2.testing.drivers;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FileDriverTest {

    @DisplayName("invalid file names provided:")
    @Tag("invalid_filename")
    @Test
    void whenOnFileModeInvalidFilenamesAreProvidedThrowsAnException()  {
        Scanner scanner = mock(Scanner.class);
        when(scanner.nextLine()).thenReturn("ThereIsNotSuchFileNameSoItShouldThrowAnException").thenReturn("noinputfile");
        FileDriver fileDriver = new FileDriver(scanner);
        assertThrows(RuntimeException.class, fileDriver::run);
    }
}