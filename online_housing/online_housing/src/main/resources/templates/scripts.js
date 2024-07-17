document.addEventListener("DOMContentLoaded", function () {
    function showSection(id) {
        document.querySelectorAll('section').forEach(section => {
            section.classList.add('hidden');
        });
        document.getElementById(id).classList.remove('hidden');
    }

    document.getElementById('registerForm').addEventListener('submit', function (e) {
        e.preventDefault();
        const formData = new FormData(e.target);
        const data = Object.fromEntries(formData);
        fetch('/api/owners/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        }).then(response => response.json())
          .then(data => alert(data.message || 'Registration successful'))
          .catch(error => alert('Registration failed'));
    });

    document.getElementById('loginForm').addEventListener('submit', function (e) {
        e.preventDefault();
        const formData = new FormData(e.target);
        const data = Object.fromEntries(formData);
        fetch('/api/owners/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        }).then(response => response.json())
          .then(data => {
              localStorage.setItem('token', data.token);
              showSection('housing');
          })
          .catch(error => alert('Login failed'));
    });

    document.getElementById('housingForm').addEventListener('submit', function (e) {
        e.preventDefault();
        const formData = new FormData(e.target);
        const data = Object.fromEntries(formData);
        fetch('/api/housings', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${localStorage.getItem('token')}`
            },
            body: JSON.stringify(data)
        }).then(response => response.json())
          .then(data => {
              alert('Housing submitted successfully');
              loadHousings();
          })
          .catch(error => alert('Housing submission failed'));
    });

    function loadHousings() {
        fetch('/api/housings/owner', {
            headers: {
                'Authorization': `Bearer ${localStorage.getItem('token')}`
            }
        }).then(response => response.json())
          .then(data => {
              const housingList = document.getElementById('housingList');
              housingList.innerHTML = '';
              data.content.forEach(housing => {
                  const housingDiv = document.createElement('div');
                  housingDiv.innerHTML = `
                      <h3>${housing.housingName}</h3>
                      <p>Address: ${housing.address}</p>
                      <p>Floors: ${housing.numberOfFloors}</p>
                      <p>Master Rooms: ${housing.numberOfMasterRoom}</p>
                      <p>Single Rooms: ${housing.numberOfSingleRoom}</p>
                      <p>Amount: ${housing.amount}</p>
                  `;
                  housingList.appendChild(housingDiv);
              });
          });
    }

    // Initial load
    showSection('register');
});
