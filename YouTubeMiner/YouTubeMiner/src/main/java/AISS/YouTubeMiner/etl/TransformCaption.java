package AISS.YouTubeMiner.etl;

import AISS.YouTubeMiner.model.videominer.Caption;

public class TransformCaption {

    public static Caption transformCaption(AISS.YouTubeMiner.model.youtube.caption.Caption caption){
        Caption captionFinal= new Caption();
        captionFinal.setId(caption.getId());
        captionFinal.setName(caption.getSnippet().getName());
        captionFinal.setLanguage(caption.getSnippet().getLanguage());
        return captionFinal;

    }
}
