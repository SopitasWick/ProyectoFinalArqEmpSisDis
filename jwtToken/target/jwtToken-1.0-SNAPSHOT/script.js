document.getElementById('loginForm').addEventListener('submit', function (event) {
    event.preventDefault(); // Evita que el formulario se envíe automáticamente

    let formData = {
        username: document.getElementById('username').value,
        password: document.getElementById('password').value
    };

    fetch('login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    })
            .then(response => {
                if (response.ok) {
                    return response.json(); // Devuelve el cuerpo de la respuesta como JSON
                } else {
                    throw new Error('Failed to login');
                }
            })
            .then(data => {
                console.log('Respuesta del servidor:', data); // Agregamos este log para verificar la respuesta del servidor
                localStorage.setItem('token', data.token); // Guarda el token en localStorage
                showMessage('Inicio de sesión exitoso', true);
                document.getElementById('logoutButton').style.display = 'inline'; // Muestra el botón de cerrar sesión
                if (data.notificacion === "true") {
                    alert("El día de hoy hay una cita pendiente. Se requiere confirmar el acceso para el expediente.");
                    localStorage.setItem('notificacion', data.notificacion); // Guarda el token en localStorage
                } else {
                }

                clearForm();
            })
            .catch(error => {
                console.error('Error:', error);
                showMessage('Error: Falló el inicio de sesión', false);
            });
});

document.getElementById('logoutButton').addEventListener('click', function () {
    localStorage.removeItem('token');
    localStorage.removeItem('notificacion');
    showMessage('Cierre de sesión exitoso', true);
    document.getElementById('logoutButton').style.display = 'none';
    clearForm();
});

document.getElementById('getButton').addEventListener('click', function () {
    let token = localStorage.getItem('token');
    if (token) {
        fetch('api/recurso', {
            method: 'GET',
            headers: {
                'Authorization': 'Bearer ' + token
            }
        })
                .then(response => {
                    if (response.ok) {
                        return response.json();
                    } else {
                        throw new Error('Failed to fetch resource');
                    }
                })
                .then(data => {
                    console.log('GET Recurso successful:', data);
                })
                .catch(error => {
                    console.error('Error:', error);
                });
    } else {
        showMessage('Token no disponible. Inicia sesión primero.', false);
    }
});

document.getElementById('postButton').addEventListener('click', function () {
    let token = localStorage.getItem('token');
    if (token) {
        fetch('api/recurso', {
            method: 'POST',
            headers: {
                'Authorization': 'Bearer ' + token
            }
        })
                .then(response => {
                    if (response.ok) {
                        return response.json();
                    } else {
                        throw new Error('Failed to fetch resource');
                    }
                })
                .then(data => {
                    console.log('POST Recurso successful:', data);
                })
                .catch(error => {
                    console.error('Error:', error);
                });
    } else {
        showMessage('Token no disponible. Inicia sesión primero.', false);
    }
});

document.getElementById('putButton').addEventListener('click', function () {
    let token = localStorage.getItem('token');
    if (token) {
        fetch('api/recurso', {
            method: 'PUT',
            headers: {
                'Authorization': 'Bearer ' + token
            }
        })
                .then(response => {
                    if (response.ok) {
                        return response.json();
                    } else {
                        throw new Error('Failed to fetch resource');
                    }
                })
                .then(data => {
                    console.log('PUT Recurso successful:', data);
                })
                .catch(error => {
                    console.error('Error:', error);
                });
    } else {
        showMessage('Token no disponible. Inicia sesión primero.', false);
    }
});

document.getElementById('deleteButton').addEventListener('click', function () {
    let token = localStorage.getItem('token');
    if (token) {
        fetch('api/recurso', {
            method: 'DELETE',
            headers: {
                'Authorization': 'Bearer ' + token
            }
        })
                .then(response => {
                    if (response.ok) {
                        return response.json();
                    } else {
                        throw new Error('Failed to fetch resource');
                    }
                })
                .then(data => {
                    console.log('DELETE Recurso successful:', data);
                })
                .catch(error => {
                    console.error('Error:', error);
                });
    } else {
        showMessage('Token no disponible. Inicia sesión primero.', false);
    }
});


function showMessage(message, isSuccess) {
    let messageElement = document.getElementById('message');
    messageElement.textContent = message;
    messageElement.style.color = isSuccess ? 'green' : 'red';
    messageElement.style.display = 'block';
    setTimeout(() => {
        messageElement.style.display = 'none';
    }, 3000); // Oculta el mensaje después de 3 segundos
}

function clearForm() {
    document.getElementById('username').value = '';
    document.getElementById('password').value = '';
}