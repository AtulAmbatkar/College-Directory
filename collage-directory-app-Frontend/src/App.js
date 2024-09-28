import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'; // Update imports
import LoginPage from './Components/LoginPage';
import StudentDashboard from './Components/StudentDashboard';
import FacultyDashboard from './Components/FacultyDashboard';
import AdminDashboard from './Components/AdminDashboard';
import ProtectedRoute from './Components/ProtectedRoute';

const App = () => {
    return (
        <Router>
            <Routes>  
              <Route path="/login" element={<LoginPage />} />
                <Route path="/student-dashboard" element={<ProtectedRoute component={StudentDashboard} />} />
                <Route path="/faculty-dashboard" element={<ProtectedRoute component={FacultyDashboard} />} />
                <Route path="/admin-dashboard" element={<ProtectedRoute component={AdminDashboard} />} />
            </Routes>
        </Router>
    );
};

export default App;
