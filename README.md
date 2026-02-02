# Orders and Notifications Management System

## Overview

The **Orders and Notifications Management System** is responsible for handling product listings, customer accounts, order creation (simple and compound), shipping operations, and a flexible notification system with multilingual templates and queue-based delivery simulation.

---

## Core Features

### 1. Product Management

* Display a list of all products available for purchase.
* Each product includes:

  * Serial number
  * Name
  * Vendor
  * Category
  * Price
* The system should also show the **remaining stock count per category**.

---

### 2. Customer Accounts

* Customers can create accounts in the system.
* Each account has a **wallet balance**.
* This balance is used for:

  * Purchasing products
  * Paying shipping fees

---

### 3. Order Types

The system supports two types of orders:

#### a. Simple Orders

* Placed by a single customer.
* Can contain one or multiple products.
* Delivered to a single location.

#### b. Compound Orders

* A compound order groups multiple orders headed to **nearby locations** to reduce shipping fees.
* A customer can include:

  * Their own order
  * Orders from friends living nearby (e.g., multiple locations within El-Dokki)
* Each participant has their own products and account.

---

### 4. Order Details

* The system should be able to list **full details** of:

  * Simple orders
  * Compound orders
* Details include products, customers involved, prices, and shipping status.

---

### 5. Balance Deduction on Order Placement

* When placing an order:

  * The **product cost** is deducted from each customer’s balance.
  * For compound orders, each participant pays only for their own products.

---

### 6. Shipping & Shipping Fees

* After placing an order, users can ship it.

#### Simple Order Shipping

* Shipping fees are deducted **only from the order owner’s account**.

#### Compound Order Shipping

* Shipping fees are **shared and deducted from all participating customers**.

---

### 7. Notification Templates Management

The system includes a powerful notification module with support for templates.

#### Notification Templates

* Managed centrally before system launch.
* Each template has:

  * Subject
  * Content
  * Supported languages
  * Supported channels:

    * Email
    * SMS
  * Placeholders (e.g. `{x}`, `{y}`)

#### Example

Template:

```
Dear {x}, your booking of the {y} is confirmed. Thanks for using our store :)
```

Actual message sent:

```
Dear Nabil, your booking of the mobile charger is confirmed. Thanks for using our store :)
```

#### Required Templates

* At least **two different templates** for:

  * Order placement
  * Order shipment
* Each template must:

  * Have different wording
  * Use different numbers of placeholders

---

### 8. Notifications Queue

* Created notifications are inserted into a **notifications queue**.
* The queue represents messages **waiting to be sent**.
* The system should allow:

  * Viewing the current contents of the queue

---

### 9. Order Cancellation

* Customers can:

  * Cancel an order placement
  * Cancel only the shipping
* Cancellations are allowed **within a pre-configured time window**.
* The system must update balances, order status, and notifications accordingly.

---

### 10. Notification Delivery Simulation & Statistics

* After a configured time:

  * Notifications are automatically removed from the queue (simulating successful delivery).
* The system should provide **live statistics**, including:

  * 📧 Most notified email address / 📱 phone number
  * 📝 Most frequently sent notification template

---

## Goal

This module aims to provide a **scalable, modular, and realistic simulation** of an e-commerce order and notification system, focusing on correctness, flexibility, and observability.
