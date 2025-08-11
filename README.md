# Selenium Automation Project

A sample Selenium-based automation framework for browser testing and web scraping.  
Built using Python and Selenium WebDriver, this project demonstrates automated UI interactions, element handling, and reporting.

---

## 📌 Features

- Cross-browser support (Chrome, Firefox, Edge)
- Page Object Model (POM) design pattern
- Configurable test data & environment setup
- Explicit and implicit waits
- Screenshots on test failure
- HTML test reports

---

## 🛠 Prerequisites

Before you begin, ensure you have:

- Python 3.9+ installed  
- Google Chrome or another supported browser installed  
- pip (Python package installer)

---

## 📦 Installation

1. Clone the repository
    bash
    git clone https://github.com/yourusername/selenium-automation.git
    cd selenium-automation
    

2. Create and activate a virtual environment
    bash
    python -m venv venv
    source venv/bin/activate   # macOS/Linux
    venv\Scripts\activate      # Windows
    

3. Install dependencies
    bash
    pip install -r requirements.txt
    

---

## ⚙️ Configuration

Edit the `config/config.yaml` file to set:
- Browser: chrome / firefox / edge
- Base URL: website under test
- Timeouts: implicit & explicit wait times

Example:
```yaml
browser: chrome
base_url_
