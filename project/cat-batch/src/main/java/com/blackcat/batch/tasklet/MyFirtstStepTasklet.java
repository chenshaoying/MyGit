package com.blackcat.batch.tasklet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class MyFirtstStepTasklet implements Tasklet{
	
	private static final Logger log = LoggerFactory.getLogger(MyFirtstStepTasklet.class);
	
	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
		log.info("start FirtstStepTasklet");
		return RepeatStatus.FINISHED;
	}

}
