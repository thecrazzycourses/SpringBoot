package com.pluralsight.springbatch.patientbatchloader.config;

import com.pluralsight.springbatch.patientbatchloader.PatientBatchLoaderApp;
import com.pluralsight.springbatch.patientbatchloader.domain.PatientRecord;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.test.MetaDataInstanceFactory;
import org.springframework.batch.test.StepScopeTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PatientBatchLoaderApp.class)
@ActiveProfiles("dev")
public class BatchJobConfigurationTest {

    @Autowired
    private Job job;

    @Autowired
    private FlatFileItemReader<PatientRecord> reader;

    private JobParameters jobParameters;

    @Before
    public void setUp() {
        Map<String, JobParameter> params = new HashMap<>();
        params.put(Constants.JOB_PARAM_FILE_NAME, new JobParameter("test-unit-testing.csv"));
        jobParameters = new JobParameters(params);
    }

    @Test
    public void test() {
        assertNotNull(job);
        assertEquals(Constants.JOB_NAME, job.getName());
    }

    @Test
    public void testReader() throws Exception {
        StepExecution stepExecution = MetaDataInstanceFactory.createStepExecution(jobParameters);
        int count = 0;
        try {
            count = StepScopeTestUtils.doInStepScope(stepExecution, () -> {
                int numPatients = 0;
                PatientRecord patient;
                try {
                    reader.open(stepExecution.getExecutionContext());
                    while ((patient = reader.read()) != null) {
                        assertNotNull(patient);
                        assertEquals("72739d22-3c12-539b-b3c2-13d9d4224d40", patient.getSourceId());
                        assertEquals("Hettie", patient.getFirstName());
                        assertEquals("P", patient.getMiddleInitial());
                        assertEquals("Schmidt", patient.getLastName());
                        assertEquals("rodo@uge.li", patient.getEmailAddress());
                        assertEquals("(805) 384-3727", patient.getPhoneNumber());
                        assertEquals("Hutij Terrace", patient.getStreet());
                        assertEquals("Kahgepu", patient.getCity());
                        assertEquals("ID", patient.getState());
                        assertEquals("40239", patient.getZip());
                        assertEquals("6/14/1961", patient.getBirthDate());
                        assertEquals("I", patient.getAction());
                        assertEquals("071-81-2500", patient.getSsn());
                        numPatients++;
                    }
                } finally {
                    try { reader.close(); } catch (Exception e) { fail(e.toString()); }
                }
                return numPatients;
            });
        } catch (Exception e) {
            fail(e.toString());
        }
        assertEquals(1, count);
    }
}
