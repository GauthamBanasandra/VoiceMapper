import FeatureVector.FeatureVectorBuilder;

import java.io.IOException;

/**
 * Created by gauth_000 on 15-Aug-16.
 */
public class VoiceMapper
{
    public static void main(String[] args) throws IOException
    {
        FeatureVectorBuilder builder=new FeatureVectorBuilder();
        builder.dump_feature_vector("C:\\Users\\gauth_000\\Documents\\Projects\\VoiceMapper\\Voice samples\\sample1.m4a",
                "C:\\Users\\gauth_000\\Documents\\Projects\\VoiceMapper\\Voice samples\\sample1_dump.txt",
                "cepstraFrontEnd");
    }
}
