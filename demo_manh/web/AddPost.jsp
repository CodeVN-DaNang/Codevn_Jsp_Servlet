<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Pinterest Pin Creation Tool Clone</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <style>
            /* Custom Styles */
            body {
                font-family: Arial, sans-serif;
                background-color: #f2f2f2;
                color: #333;
                margin: 0;
                padding: 0;
            }

            .container {
                max-width: 940px;
                margin: 20px auto;
                padding: 24px;
            }

            .pin-creator-container {
                background-color: #fff;
                border-radius: 8px;
                box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);
                padding: 20px;
                margin-bottom: 24px;
            }

            .pin-creator-header {
                border-bottom: 1px solid #e0e0e0;
                padding-bottom: 16px;
                margin-bottom: 24px;
            }

            .pin-creator-header h2 {
                font-size: 24px;
                font-weight: bold;
                margin: 0;
                color: #333;
            }

            .pin-creator-header p {
                margin: 8px 0 0;
                color: #666;
                font-size: 14px;
            }

            .pin-creator-input {
                width: 100%;
                padding: 12px;
                margin-bottom: 16px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
                font-size: 16px;
                background-color: #f9f9f9;
                color: #333;
            }

            .pin-creator-button {
                display: inline-block;
                background-color: #e60023;
                color: #fff;
                border: none;
                border-radius: 4px;
                padding: 12px 24px;
                cursor: pointer;
                font-size: 16px;
                transition: background-color 0.3s ease;
            }

            .pin-creator-button:hover {
                background-color: #c7001d;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <div class="container">
            <div class="pin-creator-container">
                <div class="pin-creator-header">
                    <h2>Create a Pin</h2>
                    <p>Choose an image and add a description to create your Pin.</p>
                </div>
                <form id="pinForm">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="input-group mb-3">
                                    <div class="custom-file">
                                        <input type="file" id="imageUpload" accept="image/*">
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <input id="post_title" name="post_title" class="form-control pin-creator-input mb-3" rows="3" placeholder="Post Title..." aria-label="Description"></input>
                                <textarea id ="post_description" name="post_description" class="form-control pin-creator-input mb-3" rows="3" placeholder="Post Description..." aria-label="Description"></textarea>
                                <textarea id="post_tag" name="post_tag" class="form-control pin-creator-input mb-3" rows="3" placeholder="Post Tag..." aria-label="Description"></textarea>
                            </div>
                        </div>
                    </div>
                    <button type="button" onclick="uploadImage()" class="btn btn-danger btn-block pin-creator-button">Save Pin</button>
                </form>
            </div>
        </div>


    </body>
    <script src="https://www.gstatic.com/firebasejs/8.0.1/firebase-app.js"></script>
    <script src="https://www.gstatic.com/firebasejs/8.0.1/firebase-storage.js"></script>
    <script src="https://www.gstatic.com/firebasejs/8.0.1/firebase-analytics.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>

                        const firebaseConfig = {
                            apiKey: "AIzaSyAvqIPLfHBPy36nLl9X34o1D7nwteD2P3g",
                            authDomain: "fir-firebase-e6882.firebaseapp.com",
                            projectId: "fir-firebase-e6882",
                            storageBucket: "fir-firebase-e6882.appspot.com",
                            messagingSenderId: "172889142615",
                            appId: "1:172889142615:web:b947b4b29705256756fa12",
                            measurementId: "G-WQBK2KXRK2"
                        };
                        const app = firebase.initializeApp(firebaseConfig);
                        console.log('Firebase initialized:', app);

                        const storageRef = firebase.storage().ref();
                        console.log('Storage Reference:', storageRef);

                        const imgUrl = '';
                        function uploadImage() {
                            const fileInput = document.getElementById('imageUpload');
                            console.log('File Input:', fileInput);
                            const file = fileInput.files[0];
                            console.log('Selected File:', file);

                            if (file) {
                                const storageRef = firebase.storage().ref();
                                console.log('Storage Reference:', storageRef);
                                // Upload file
                                const uploadTask = storageRef.child(file.name).put(file);
                                console.log('Upload Task:', uploadTask);

                                uploadTask.then((snapshot) => {
                                    alert('Image uploaded successfully');
                                    // You can retrieve the download URL for the image
                                    snapshot.ref.getDownloadURL().then((downloadURL) => {
                                        console.log('File available at', downloadURL);
                                        // Here, you can do further processing with the download URL, such as saving it to a database

                                        const pinForm = document.getElementById('pinForm');
                                        const formData = new FormData(pinForm);
                                        const post_title = document.getElementById('post_title').value;
                                        const post_description = document.getElementById('post_description').value;
                                        const post_tag = document.getElementById('post_tag').value;

                                        const postData = {
                                            post_title: post_title,
                                            post_description: post_description,
                                            post_tag: post_tag,
                                            imageURL: downloadURL // URL of the uploaded image
                                        };
                                        $.ajax({
                                            type: "POST",
                                            url: "/demo_manh/addPost",
                                            data: postData,
                                            success: function (response) {
                                                alert('success');
                                            },
                                            error: function (xhr, status, error) {
                                                console.error('Error:', error);
                                            }
                                        });
                                    });
                                }).catch((error) => {
                                    alert('Error uploading image: ' + error.message);
                                });
                            } else {
                                alert('Please select an image to upload.');
                            }
                        }

                    
    </script>
</html>
