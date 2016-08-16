package FeatureVector;

import edu.cmu.sphinx.tools.feature.FeatureFileDumper;
import edu.cmu.sphinx.util.props.ConfigurationManager;

import java.io.IOException;

/**
 * Created by gauth_000 on 16-Aug-16.
 */
public class FeatureVectorBuilder
{
    private ConfigurationManager configurationManager;

    public FeatureVectorBuilder()
    {
        this.configurationManager=new ConfigurationManager(FeatureVectorBuilder.class.getResource("/resources/frontend.config.xml"));
    }

    public void dump_feature_vector(String inputAudioFileName, String outputFileName, String frontEndName) throws IOException
    {
        FeatureFileDumper featureDumper=new FeatureFileDumper(configurationManager, frontEndName);
        featureDumper.processFile(inputAudioFileName);
        featureDumper.dumpAscii(outputFileName);
    }
}
