Problem Statement:
Design a Coupon Recommendation System for Zepto that fulfills the following requirements:

Key Requirements:
Coupon Recommendation:

Recommend applicable coupons for a given order.

Evaluate rules dynamically based on the user's order.

Support conditions like product type, user type, and payment method.

Concurrency:

Ensure thread safety for rule evaluation when multiple users access the system.
Optimization:

Optimize the rule evaluation process to minimize redundant checks.
Concurrency Requirements:
Thread safety for concurrent requests.

Efficient use of multi-threading during rule evaluations.