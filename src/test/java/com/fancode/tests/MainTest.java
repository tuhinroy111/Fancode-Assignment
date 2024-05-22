package com.fancode.tests;

import com.fancode.api.BusinessLogic;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class MainTest {
    @Test
    public void testFanCodeUsersCompletion() throws IOException {
        BusinessLogic.getUserWithValidCompletionPercentage(new String[]{});
    }
}
