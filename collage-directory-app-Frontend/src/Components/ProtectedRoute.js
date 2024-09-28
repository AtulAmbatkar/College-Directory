// src/components/ProtectedRoute.js
import React from 'react';
import { Route, Navigate } from 'react-router-dom'; 
const isAuthenticated = () => {
    const token = localStorage.getItem('token');
    return !!token; 
};

const ProtectedRoute = ({ component: Component, ...rest }) => (
    <Route
        {...rest}
        render={props =>
            isAuthenticated() ? (
                <Component {...props} />
            ) : (
                <Navigate to="/login" />  
            )
        }
    />
);

export default ProtectedRoute;
