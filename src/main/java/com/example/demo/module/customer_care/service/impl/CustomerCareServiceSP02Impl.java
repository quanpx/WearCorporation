package com.example.demo.module.customer_care.service.impl;

import com.example.demo.client_ui.dto.feedback.FeedbackDTO;
import com.example.demo.client_ui.dto.product.ProductReviewDTO;
import com.example.demo.module.customer_care.service.CustomerCareService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("sp02-customer-care")
public class CustomerCareServiceSP02Impl implements CustomerCareService {
    @Override
    public String sendComment(ProductReviewDTO productReviewDTO) {
        return null;
    }
//    private final List<ProductReviewDTO> PRODUCT_REVIEW_LIST = Arrays.asList(
//            new ProductReviewDTO(1, 1, "Jonathon Andrew",
//                    "/images/blog/avater-1.jpg", "July 02, 2015, at 11:34",
//                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque at " +


//                            "magna ut ante eleifend eleifend. Lorem ipsum dolor sit amet, " +
//                            "consectetur adipisicing elit. Magni natus, nostrum iste non delectus " +
//                            "atque ab a accusantium optio, dolor!"),
//            new ProductReviewDTO(2, 4, "Jonathon Andrew",
//                    "/images/blog/avater-4.jpg", "July 02, 2015, at 11:34",
//                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque at " +
//                            "magna ut ante eleifend eleifend. Lorem ipsum dolor sit amet, " +
//                            "consectetur adipisicing elit. Magni natus, nostrum iste non delectus " +
//                            "atque ab a accusantium optio, dolor!"),
//            new ProductReviewDTO(3, 1, "Jonathon Andrew",
//                    "/images/blog/avater-1.jpg", "July 02, 2015, at 11:34",
//                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque at " +
//                            "magna ut ante eleifend eleifend. Lorem ipsum dolor sit amet, " +
//                            "consectetur adipisicing elit. Magni natus, nostrum iste non delectus " +
//                            "atque ab a accusantium optio, dolor!")
//    );

    @Override
    public List<ProductReviewDTO> getAllProductReviewByProductId(Integer productId) {
//        return PRODUCT_REVIEW_LIST;
        return null;
    }

    @Override
    public String sendFeedback(FeedbackDTO feedbackDTO) {
        return null;
    }
}
