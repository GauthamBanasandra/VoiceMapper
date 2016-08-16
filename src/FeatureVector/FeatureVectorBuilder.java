package FeatureVector;

import edu.cmu.sphinx.tools.feature.FeatureFileDumper;
import edu.cmu.sphinx.util.props.ConfigurationManager;

import java.io.IOException;

/**
 * Created by gauth_000 on 16-Aug-16.
 * Builds the feature vector for a given audio file
 */
public class FeatureVectorBuilder
{
    // Configuration file - contains info about the model to be used etc
    private ConfigurationManager configurationManager;

    public FeatureVectorBuilder()
    {
        this.configurationManager=new ConfigurationManager(FeatureVectorBuilder.class.getResource("/resources/frontend.config.xml"));
    }

    /**
     * @param inputAudioFileName Path to input audio file name
     * @param outputFileName Path to output file name to dump the feature vector
     * @param frontEndName Possible values are - cepstraFrontEnd, spectraFrontEnd, plpFrontEnd
     * @throws IOException
     */
    public void dump_feature_vector(String inputAudioFileName, String outputFileName, String frontEndName) throws IOException
    {
        FeatureFileDumper featureDumper=new FeatureFileDumper(configurationManager, frontEndName);
        featureDumper.processFile(inputAudioFileName);
        featureDumper.dumpAscii(outputFileName);
    }
}
