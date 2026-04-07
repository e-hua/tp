package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static seedu.address.logic.Messages.MESSAGE_INVALID_PREFIX;
import static seedu.address.logic.commands.EditCommand.COMMAND_WORD;
import static seedu.address.logic.commands.EditCommand.MESSAGE_USAGE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TELEGRAM;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.logic.parser.exceptions.ParseException;

class PrefixUtilTest {

    private static final Set<Prefix> SUPPORTED_PREFIXES =
            Set.of(PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS, PREFIX_TELEGRAM, PREFIX_TAG);

    @Test
    void checkUnsupportedPrefixes_supportedPrefixes_noExceptionThrown() {
        String args = "n/John p/12345678 e/john@example.com";

        // Checks unsupported prefixes using edit-command settings
        assertDoesNotThrow(() ->
            PrefixUtil.checkUnsupportedPrefixes(args, SUPPORTED_PREFIXES, COMMAND_WORD, MESSAGE_USAGE));
    }

    @Test
    void checkUnsupportedPrefixes_containsUnsupportedPrefix_throwsParseException() {
        String args = "n/John c/CS2103T e/john@example.com";
        String expectedMessage = String.format(MESSAGE_INVALID_PREFIX,
                    "c/", COMMAND_WORD, MESSAGE_USAGE);

        assertThrows(ParseException.class, expectedMessage, () ->
            PrefixUtil.checkUnsupportedPrefixes(args, SUPPORTED_PREFIXES, COMMAND_WORD, MESSAGE_USAGE));
    }
}
