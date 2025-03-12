# Malicious Android App Development

This repository contains source code for various Android applications that demonstrate solutions to different Android security challenges. The projects showcased here offer insights into potential vulnerabilities and malicious behaviors within Android apps, serving as a resource for educational and research purposes.

---

## Disclaimer

**Warning:** The contents of this repository are intended strictly for educational and research purposes only. Do **not** use this code for any illegal or unethical activities. The author is not responsible for any misuse of these examples. Always ensure you have proper authorization before testing security techniques on any system.

---

## Overview

The repository is organized into multiple subdirectories, each representing a different challenge or demonstration of Android security issues. Below is an overview of some key examples:

- **Day 1: Simple App with Button, TextView, and Function**  
  A basic Android app demonstrating UI components and fundamental functions.

- **Day 2: Sending and Receiving Intents**  
  Explores inter-application communication using intents.

- **Day 3: App with Internet Permission & Solving Android Challenge 1**  
  Covers the usage of network permissions and addresses the first Android challenge.

- **Day 4: Integrating Native Library**  
  Demonstrates how to integrate and leverage native libraries within an Android application.

- **Day 5: Sending PendingIntent to Malicious App**  
  Shows how pending intents can be misused to trigger unintended behavior.

- **Day 6: Receiving Pending Intent With Mutable Flag**  
  Highlights potential security issues when using mutable flags in pending intents.

- **Day 7: Starting Services and Sending Over and Again**  
  Demonstrates repeated service initiation and inter-process communication vulnerabilities.

- **Day 8: Binding with Services & Starting Services**  
  Provides examples of service binding and the associated security implications.

- **Day 9: Write With FileProvider**  
  Explores vulnerabilities arising from misconfigured FileProvider usage.

- **Day 10: Insecure Rootpath FileProvider Config**  
  Focuses on common misconfigurations in FileProvider that can lead to security breaches.

- **Day 11: Hijack the Notification Action**  
  Illustrates how notification actions can be hijacked to execute malicious behavior.

- **Day 12: Expose Native Functionality to the WebView**  
  Demonstrates the risks of exposing native code to WebView components.

- **Day 13: Receiving PendingIntent With Mutable Flag (Alternate Example)**  
  Offers additional examples on the use and misuse of mutable pending intents.

- **Day 14: Sending Intents, PendingIntent, and Sending Data to Widget**  
  Covers advanced intent handling, including interactions with widgets.

- **Day 15: ContentProvider Access With Intent**  
  Explores potential exploitation of ContentProviders via intents.

- **Day 16: Spoofing Notification**  
  Demonstrates techniques to spoof notifications.

- **Day 17: Broadcast**  
  Examines the use of broadcasts and the potential security pitfalls.

- **Day 18: BroadcastReceiver**  
  Shows how broadcast receivers can be exploited if not properly secured.

- **Day 19: Ordered Broadcast**  
  Explores the ordering of broadcast messages and its security implications.

- **Day 20: Deep Links**  
  Discusses deep linking in Android and possible associated vulnerabilities.

### Additional Projects

- **AppWithInternetAcess** – A sample project focused on network access.
- **CORS_in_webview** – Demonstrates Cross-Origin Resource Sharing (CORS) issues within a WebView.
- **MyApplication Series** – Various versions of sample applications demonstrating different vulnerabilities.

---

## Requirements

- **Android Studio** – Latest version recommended.
- **Java Development Kit (JDK)**
- **Android SDK**
- An **Android Emulator** or physical device for testing.

---

## Setup

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/patali09/Malicious-Android-App-Development.git
