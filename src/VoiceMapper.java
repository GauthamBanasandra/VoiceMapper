import FeatureVector.FeatureVectorBuilder;

import java.io.IOException;

/**
 * Created by gauth_000 on 15-Aug-16.
 */
public class VoiceMapper
{
    public static void main(String[] args) throws IOException
    {
        FeatureVectorBuilder builder = new FeatureVectorBuilder();
        /*for (int i = 2; i < 7; i++)
        {
            builder.dump_feature_vector("C:\\Users\\gauth_000\\Documents\\Projects\\VoiceMapper\\Voice samples\\Sample\\Recording (" + i + ").m4a",
                    "C:\\Users\\gauth_000\\Documents\\Projects\\VoiceMapper\\Voice samples\\Sample\\Recording (" + i + ").txt",
                    "cepstraFrontEnd");
        }*/
        builder.dump_feature_vector("C:\\Users\\gauth_000\\Documents\\Projects\\VoiceMapper\\Voice samples\\Sample\\Recording.m4a",
                "C:\\Users\\gauth_000\\Documents\\Projects\\VoiceMapper\\Voice samples\\Sample\\Recording.txt",
                "cepstraFrontEnd");
    }
}
