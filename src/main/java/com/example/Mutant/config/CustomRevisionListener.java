package com.example.Mutant.config;

import org.hibernate.envers.RevisionListener;

import com.example.Mutant.audit.Revision;

public class CustomRevisionListener implements RevisionListener {
	
	public void newRevision(Object revisionEntity) {
		final Revision revision = (Revision) revisionEntity;
		
		
	}

}
