package com.bikefactory;

import com.bikefactory.exception.SpecialOfferNotFoundException;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@DisplayName("Testing access to DB")
@AutoConfigureMockMvc
class BikeFactoryApplicationTests {

    private static final String URL = "/bike-factory/customer";
    private static final String URL_SPECIAL_OFFER = "/bike-factory/special-offer";
    private static final String URL_SPECIAL_ORDER_DETAIL = "/bike-factory/order-detail";

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup().build();
    }

    @Nested
    @DisplayName("Accessing the customer controller")
    class accessingCustomerController {

        @Test
        void getCustomerById() throws Exception {
            mockMvc.perform(get(URL+"/1"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("customerId", is(1)))
                    .andExpect(jsonPath("personId", is(0)))
                    .andExpect(jsonPath("storeId", is(934)))
                    .andExpect(jsonPath("territoryId", is(1)))
                    .andExpect(jsonPath("accountNumber", is("AW00000001")));

        }

        @Test
        void getCustomerByAccount() throws Exception {
            mockMvc.perform(get(URL+"/account/AW00000011"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("customerId", is(11)))
                    .andExpect(jsonPath("personId", is(0)))
                    .andExpect(jsonPath("storeId", is(1022)))
                    .andExpect(jsonPath("territoryId", is(6)));

        }
    }

    @Nested
    @DisplayName("Testing the specialOfferController")
    class accessingSpecialOfferController {

        @Test
        void getSpecialOffer() throws Exception{
            mockMvc.perform(get(URL_SPECIAL_OFFER+"/offers")
                    .param("specialOfferId", "1")
                    .param("productId", "707"))
                    .andExpect(status().isOk());
        }

        @Test
        void getInvalidSpecialOffer() throws Exception{
            mockMvc.perform(get(URL_SPECIAL_OFFER+"/offers")
                    .param("specialOfferId", "a")
                    .param("productId", "707"))
                    .andExpect(status().isBadRequest());
        }

        @Test
        void specialOfferNotFound() throws Exception{
            mockMvc.perform(get(URL_SPECIAL_OFFER+"/offers")
                    .param("specialOfferId", "11111111")
                    .param("productId", "111111111"))
                    .andExpect(status().isNotFound())
                    .andExpect(jsonPath("$.error", is(SpecialOfferNotFoundException.EXCEPTION_CODE)));
        }
    }

    @Nested
    @DisplayName("Accessing order details controller")
    class accessingOrderDetailsController {

        @Test
        void getSpecialOffer() throws Exception{
            mockMvc.perform(get(URL_SPECIAL_ORDER_DETAIL+"/orders")
                    .param("salesOrderId", "43659")
                    .param("salesOrderDetailId", "2"))
                    .andExpect(status().isOk());
            }

        @Test
        void getInvalidSpecialOffer() throws Exception{
            mockMvc.perform(get(URL_SPECIAL_OFFER+"/orders")
                    .param("salesOrderId", "a")
                    .param("salesOrderDetailId", "707"))
                    .andExpect(status().isNotFound());
            }

        @Test
        void specialOfferNotFound() throws Exception{
            mockMvc.perform(get(URL_SPECIAL_OFFER+"/offers")
                    .param("salesOrderId", "11111111")
                    .param("salesOrderDetailId", "111111111"))
                    .andExpect(status().isBadRequest());
            }
        }

    }