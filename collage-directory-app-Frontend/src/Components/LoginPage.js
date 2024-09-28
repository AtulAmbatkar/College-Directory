// src/components/LoginPage.js
import React, { useState } from 'react';
import './styles.css';

const LoginPage = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [usserRole, setRole] = useState('');
    const [error, setError] = useState('');

    const handleLogin = async (event) => {
        event.preventDefault();
        setError('');

        console.log(usserRole)

        const response = await fetch('http://localhost:8080/college-directory-app/user/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ username, password, usserRole }), // Correct the field to userRole
        });

        if (response.ok) {
            const data = await response.json();
            console.log(data);

            localStorage.setItem('token', data.token);
            localStorage.setItem('userRole', data.userRole); // Save correct role in localStorage

            switch (data.usserRole) {
                case 'STUDENT':
                    window.location.href = '/student-dashboard';
                    break;
                case 'FACULTY_MEMBER':
                    window.location.href = '/faculty-dashboard';
                    break;
                case 'ADMINISTRATOR':
                    window.location.href = '/admin-dashboard';
                    break;
                default:
                    break;
            }
        } else {
            setError('Invalid credentials');
        }
    };

    return (
        <div className="login-container">
            <h2>Login</h2>
            <form onSubmit={handleLogin}>
                <div>
                    <label>Username:</label>
                    <input
                        type="text"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label>Password:</label>
                    <input
                        type="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label>Role:</label>
                    <select value={usserRole} onChange={(e) => setRole(e.target.value)} required>
                        <option value="" disabled>Select your role</option>
                        <option value="STUDENT">STUDENT</option>
                        <option value="FACULTY_MEMBER">FACULTY_MEMBER</option>
                        <option value="ADMINISTRATOR">ADMINISTRATOR</option>
                    </select>
                </div>
                <button type="submit">Login</button>
                {error && <div className="error">{error}</div>}
            </form>
        </div>
    );
};

export default LoginPage;
