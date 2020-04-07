package com.bbcrecipes.extensions;

import com.bbcrecipes.utils.Drivers;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class JunitTestWatcher extends Drivers implements TestWatcher, AfterAllCallback {
    private List<TestResultStatus> testResultsStatus = new ArrayList<>();
    private JunitTestRule testRule = new JunitTestRule();

    private enum TestResultStatus {
        SUCCESSFUL, ABORTED, FAILED, DISABLED;
    }

    @Override
    public void testDisabled(ExtensionContext extensionContext, Optional<String> optional) {
        log.info("Test Disabled for test: {} with reason :- {}", extensionContext.getDisplayName(), optional.orElse("No reason"));

        testResultsStatus.add(TestResultStatus.DISABLED);
    }

    @Override
    public void testSuccessful(ExtensionContext extensionContext) {
        log.info("Test Successful for test: {} ", extensionContext.getDisplayName());

        testResultsStatus.add(TestResultStatus.SUCCESSFUL);
    }

    @Override
    public void testAborted(ExtensionContext extensionContext, Throwable throwable) {
        log.info("Test Aborted for test: {} ", extensionContext.getDisplayName());

        testResultsStatus.add(TestResultStatus.ABORTED);
    }

    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable throwable) {

        log.info("Test Failed for test: {} ", extensionContext.getDisplayName());
        testResultsStatus.add(TestResultStatus.FAILED);
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        Map<TestResultStatus, Long> summary = testResultsStatus.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        log.info("Test result summary for: {} {}", extensionContext.getDisplayName(), summary.toString());
    }
};