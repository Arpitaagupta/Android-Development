
# CodeGuru - Your Personalized Learning Platform

CodeGuru is an affordable learning platform that provides personalized, hands-on learning experiences in a variety of areas of interest. Our platform allows users to access a wide range of resources, including video tutorials, webinars, hackathons, coding games, and more. We revolutionize the learning process by offering mentorship to help users clear various coding paradigms.

Our platform offers a wide range of features, including a single source for all learning materials, courses that get unlocked based on the student's performance, coding games that make the learning experience interactive and engaging, and seminars, webinars, and mentorship to ensure that users receive a well-rounded learning experience.

We also introduce progress graphs to help users track their learning progress and engage in community activities with other learners and achievers in the subject. Our platform explains the importance of engaging in open source (GitHub), provides badges based on ranking, and offers internship opportunities.

We also provide complete roadmaps, notes, and quizzes on every topic, and each course has a mentor to guide and support users throughout their learning journey. With CodeGuru, you can unlock your potential and gain the skills you need to succeed in the world of coding.

## Key Features

- All resources under one roof
- Courses get unlocked based on students' performance
- Coding games are introduced to make it interactive and engaging
- Seminars, webinars, and mentorship are provided
- Progress graph is introduced
- Engaging in community and interacting with the achievers of that subject
- Explaining the importance of engaging in open source (Github)
- Badges are provided based on the rankings
- Internship opportunities
- Complete roadmaps
- Notes and quizzes on every topic
- Every course has a mentor

Contributors
------------

-   [Abhishek Bhattacharjee](https://github.com/AbhiiVops) - Developer
-   [Arpita Gupta](https://github.com/Arpitaagupta) - Developer

Installation Guide
------------

Follow the below steps to install and run CodeGuru on your system:

1.  System Requirements:

    -   Operating System: Windows 10, macOS, or Linux
    -   Android Studio 4.2 or higher
    -   Java Development Kit (JDK) 11 or higher
    -   Internet connection for accessing webinars, hackathons, and other online resources.
2.  Download CodeGuru:

    -   You can download the project using the "Clone or download" button on GitHub.
3.  Build CodeGuru:

    -   Open Android Studio and select "Open an existing project."
    -   Navigate to the directory where you have downloaded CodeGuru and select the project.
    -   Once the project has been imported, build the project using the "Build" menu in Android Studio.
4.  Run CodeGuru:

    -   To run CodeGuru on an emulator, navigate to the "AVD Manager" in Android Studio, create a new virtual device, and select the device to run CodeGuru.
    -   To run CodeGuru on a physical device, connect the device to your computer, enable USB debugging in the device's developer options, and select the device to run CodeGuru.
    -   Once you have selected the device, click on the "Run" button in Android Studio to launch the application.
5.  Troubleshooting:

    -   If you encounter any issues during installation or while running CodeGuru, please check our [troubleshooting guide](https://stackoverflow.com/) for common errors and their solutions.

## How to install and run the projects

### Prerequisites

You’ll need the following:

1. **An Auth0 account.** The app uses Auth0 to provide authenticate users, which means that you need an Auth0 account. You can <a href="https://auth0.com/signup" 
  data-amp-replace="CLIENT_ID" 
  data-amp-addparams="anonId=CLIENT_ID(cid-scope-cookie-fallback-name)">
  sign up for a free account</a>, which lets you add login/logout to 10 applications, with support for 7,000 users and unlimited logins. This should suit your prototyping, development, and testing needs.
2. **An Android development setup:** 
	* Any computer running Linux, macOS, or Windows from 2013 or later with at least 8 GB RAM. When it comes to RAM, more is generally better.
	* [**Java SE Developer Kit (JDK), version 11 or later.**](https://www.oracle.com/java/technologies/javase-jdk16-downloads.html) You can find out which version is on your computer by opening a command-line interface and entering `java --version`.
	* [**Android Studio,**](https://developer.android.com/studio) version 3.6 (February 2020) or later. I used the current stable version of Android Studio when writing this article: version 2021.2.1, also known as “Chipmunk”.
	* **At least one Android SDK (Software Development Kit) platform.** You can confirm that you have one (and install one if you don’t) in Android Studio. Open **Tools → SDK Manager**. You’ll see a list of Android SDK platforms. Make sure that the current SDK (**Android 11.0 (R)** at the time of writing) is checked; if it isn’t, check it, click the **Apply** button, and click the **OK** button in the confirmation dialog that appears. Wait for the SDK platform to install and click the **Finish** button when installation is complete.
	* **An Android device, real or virtual:**
		* **Using a real device:** Connect the device to your computer with a USB cable. Make sure that your device has Developer Options and USB debugging enabled.
		* **Using a virtual device:** Using Android Studio, you can build a virtual device (emulator) that runs on your computer. Here’s my recipe for a virtual device that simulates a current-model inexpensive Android phone:
			1. Open **Tools → AVD Manager** (AVD is short for “Android Virtual Device”). The **Your Virtual Devices** window will appear. Click the **Create Virtual Device...** button.
			2. The **Select Hardware** window will appear. In the **Phone** category, select **Pixel 3a** and click the **Next** button.
			3. The **System Image** window will appear, and you’ll see a list of Android versions. Select **R** (API 30, also known as Android 11.0). If you see a **Download** link beside R, click it, wait for the OS to download, then click the **Finish** button. Then click the **Next** button.
			4. The **Android Virtual Device (AVD)** window will appear. The **AVD Name** field should contain **Pixel 3a API 30**, the two rows below it should have the titles **Pixel 3a** (a reasonable “representative” phone, released 3 years ago at the time of writing) and **R**, and in the **Startup orientation** section, **Portrait** should be selected. Click the **Finish** button.
			5. You will be back at the **Your Virtual Devices** window. The list will now contain **Pixel 3a API 30**, and that device will be available to you when you run the app.
      
      ### Running the complete project

The complete project is the result of downloading the start project and following the article’s instructions. It is provided for reference.

To use the complete project, download it, then connect it to Auth0 by doing the following:

* **Register the app in the Auth0 Dashboard:**
	* Log into the [Auth0 dashboard](https://manage.auth0.com/dashboard/), select **Applications → Applications** from the left side menu, then click the **Create Application** button.
	* Enter a name for the app in the **Name** field and choose the **Native** application type.
	* Select the **Settings** tab and copy the **Domain** and **Client ID** values.
	* Scroll down the **Settings** page and paste `app://{YOUR_DOMAIN}/android/com.auth0.Android-Login/callback` into the  **Allowed Callback URLs** and **Allowed Login URLs** fields, replacing `{YOUR_DOMAIN}` with the value you copied from the **Domain** field.
	* Scroll to the bottom of the **Settings** page and click the **Save Changes** button.
* **Configure the app to connect to Auth0:**
	* 	Open the `auth0.xml` string resource file in the app project.
	* Change the contents of the `<string name="com_auth0_scheme">` tag from `TODO: Enter the scheme for your app’s callback and logout URLs here.` to `app`. 
	* Change the contents of the `<string name="com_auth0_domain">` tag from `TODO: Enter your tenant’s domain name here.` to the **Domain** value you copied from the Auth0 dashboard.
	* Change the contents of the `<string name="com_auth0_client_id">` tag from `TODO: Enter your tenant’s domain name here.` to the **Client ID** value you copied from the Auth0 dashboard.
* Run the app!

Feedback and Support
--------------------

We are always looking to improve CodeGuru, so if you have any feedback, suggestions, or issues, please feel free to [raise an issue](https://github.com/Android-Development/issues/new) on our GitHub repository.

For any support queries or general inquiries, please contact us at <bhattabhii.ops1105@gmail.com> or <arpitagupta6620@gmail.com> .


## License

Copyright (c) 2022 [Auth0](http://auth0.com)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions: The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
