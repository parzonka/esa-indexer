package com.github.parzonka.esa.indexing;

import java.io.IOException;

import org.apache.uima.UimaContext;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import de.tudarmstadt.ukp.dkpro.core.io.jwpl.WikipediaArticleReader;
import de.tudarmstadt.ukp.dkpro.lab.ProgressMeter;

/**
 * Extends the standard WikipediaArticleReader with progress tracking.
 * 
 * @author Mateusz Parzonka
 */
public class ExtendedWikipediaArticleReader extends WikipediaArticleReader {
	
	protected ProgressMeter progressMeter;

	@Override
	public void initialize(UimaContext context) throws ResourceInitializationException {
		super.initialize(context);
		progressMeter = new ProgressMeter(getProgress()[0].getTotal());
	}

	@Override
	public void getNext(JCas jcas) throws IOException, CollectionException {
		super.getNext(jcas);
		progressMeter.next();
		getLogger().info("Indexing article " + progressMeter);
	}

}
