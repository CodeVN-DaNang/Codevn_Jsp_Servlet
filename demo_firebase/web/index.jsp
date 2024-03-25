<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

    </head>
    <body>

        <input type="file" id="imageUpload" accept="image/*">


        <button type="button" onclick="uploadImage()">Upload Image</button>
        <script src="https://www.gstatic.com/firebasejs/8.0.1/firebase-app.js"></script>
        <script src="https://www.gstatic.com/firebasejs/8.0.1/firebase-storage.js"></script>
        <script src="https://www.gstatic.com/firebasejs/8.0.1/firebase-analytics.js"></script>

        <script>

            const firebaseConfig = {
                apiKey: "AIzaSyAvqIPLfHBPy36nLl9X34o1D7nwteD2P3g",
                authDomain: "fir-firebase-e6882.firebaseapp.com",
                projectId: "fir-firebase-e6882",
                storageBucket: "fir-firebase-e6882.appspot.com",
                messagingSenderId: "172889142615",
                appId: "1:172889142615:web:e58b8e68df1468d956fa12",
                measurementId: "G-007D5YPRPW"
            };
            const app = firebase.initializeApp(firebaseConfig);
            console.log('Firebase initialized:', app);

            const storageRef = firebase.storage().ref();
            console.log('Storage Reference:', storageRef);

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
                        });
                    }).catch((error) => {
                        alert('Error uploading image: ' + error.message);
                    });
                } else {
                    alert('Please select an image to upload.');
                }
            }
        </script>
    </body>
</html>
