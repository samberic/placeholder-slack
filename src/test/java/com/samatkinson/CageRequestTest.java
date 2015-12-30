package com.samatkinson;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CageRequestTest {

    private final HeightWidthGenerator heightWidthGenerator = new HeightWidthGenerator() {
        public int height() {
            return 300;
        }

        public int width() {
            return 200;
        }
    };

    @Test
    public void correctlyFormatsValidParams() throws Exception {
        CageRequest cageRequest = new CageRequest(heightWidthGenerator,
                "calm");

        String calm = cageRequest.getFormattedUrl();
        assertThat(calm, is("https://www.placecage.com/200/300"));

        cageRequest = new CageRequest(heightWidthGenerator, "gray");
        assertThat(cageRequest.getFormattedUrl(), is("https://www.placecage.com/g/200/300"));

        cageRequest = new CageRequest(heightWidthGenerator, "crazy");
        assertThat(cageRequest.getFormattedUrl(), is("https://www.placecage.com/c/200/300"));

        cageRequest = new CageRequest(heightWidthGenerator, "gif");
        assertThat(cageRequest.getFormattedUrl(), is("https://www.placecage.com/gif/200/300"));

    }

    @Test
    public void invalidCommandsReturnCalm() throws Exception {
        CageRequest cageRequest = new CageRequest(heightWidthGenerator, "");
        assertThat(cageRequest.getFormattedUrl(), is("https://www.placecage.com/200/300"));

        cageRequest = new CageRequest(heightWidthGenerator, "crazie");
        assertThat(cageRequest.getFormattedUrl(), is("https://www.placecage.com/200/300"));

        cageRequest = new CageRequest(heightWidthGenerator, "213");
        assertThat(cageRequest.getFormattedUrl(), is("https://www.placecage.com/200/300"));

        cageRequest = new CageRequest(heightWidthGenerator, "crazy and");
        assertThat(cageRequest.getFormattedUrl(), is("https://www.placecage.com/200/300"));

    }

    @Test
    public void heightAndWidthFromGeneratorArePassedToUrl() throws Exception {
        CageRequest cageRequest = new CageRequest(new HeightWidthGenerator() {
            @Override
            public int height() {
                return 49;
            }

            @Override
            public int width() {
                return 1221;
            }
        }, "");
        assertThat(cageRequest.getFormattedUrl(), is("https://www.placecage.com/1221/49"));


    }

}
