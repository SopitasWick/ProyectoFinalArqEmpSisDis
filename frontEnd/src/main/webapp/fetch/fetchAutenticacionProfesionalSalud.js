document.getElementById('getButton').addEventListener('click', function () {
    let token = localStorage.getItem('token');
    if (token) {
        fetch('api/recurso/autenticacionProfesionalSalud', {
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
        fetch('api/recurso/autenticacionProfesionalSalud', {
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

document.getElementById('postButtonEvent').addEventListener('click', function () {
    let token = localStorage.getItem('token');
    if (token) {
        fetch('api/evento/autenticacionProfesionalSalud', {
            method: 'POST',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            body: JSON.stringify({
                "idCita": 1,
                "fechaCita": {
                    "year": 2024,
                    "month": 4,
                    "day": 16,
                    "hour": 12,
                    "minute": 0
                },
                "idMedico": 123,
                "idPaciente": 456
            })
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

document.getElementById('postButton').addEventListener('click', function () {
    let token = localStorage.getItem('token');
    if (token) {
        fetch('api/recurso/autenticacionProfesionalSalud', {
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
        fetch('api/recurso/autenticacionProfesionalSalud', {
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
        fetch('api/recurso/autenticacionProfesionalSalud', {
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


