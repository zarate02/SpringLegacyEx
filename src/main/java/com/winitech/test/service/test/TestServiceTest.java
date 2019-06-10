package com.winitech.test.service.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
(
	locations = {
		"file:src/main/webapp/WEB-INF/spring/context-cmm.xml",
		"file:src/main/webapp/WEB-INF/spring/context-db.xml"
	}
)
@WebAppConfiguration
public class TestServiceTest {		

    @Autowired WebApplicationContext context;
	
	@Rule public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();
		
    MockMvc mockMvc;
    
    @Before
    public void setUp() {
         mockMvc = 
        	MockMvcBuilders
        		 .webAppContextSetup(context)
        		 .apply(documentationConfiguration(restDocumentation))
      			 .addFilters(new CharacterEncodingFilter("UTF-8", true))
      			 .build();
    }

    /*Test*/
    @Test
    public void testCategoryController() throws Exception {
    	
    	/*전송Map*/
    	Map<String,String> parm = new HashMap<String,String>();
    	parm.put("DSR_SEQ", "TEST_DSRSEQ");
    	String postStr = new ObjectMapper().writeValueAsString(parm);
    	
        mockMvc
        	.perform(
        			post("/TestSelect")
        			.header("Accept","application/json")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .content(postStr)
        	)	
        	.andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))     
    		.andExpect(jsonPath("$[0].TEST", equalTo("TEST_DSRSEQ")))    		
    		.andDo(
            		document("DSR_SEQ",
            				requestFields(
                                    fieldWithPath("DSR_SEQ").type(JsonFieldType.STRING).description("재난번호")
            				)
            				,responseFields(
            						fieldWithPath("[].TEST").type(JsonFieldType.STRING).description("테스트")      						
            				)
            		)	
            );
    }
    
    
}