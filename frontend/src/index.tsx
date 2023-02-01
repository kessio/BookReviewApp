import React from 'react';
import ReactDOM from 'react-dom/client';
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import './index.css';
import App from './App';
import WelcomePage from './pages/WelcomePage';
import RegisterPage from './pages/RegisterPage';

const router = createBrowserRouter([
  {
    path: "/",
    element: < App/>,
  },
  {
    path: "/register",
    element: < RegisterPage/>,
  },
  {
    path: "/welcome",
    element: < WelcomePage/>,
  },
 
]);


const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <React.StrictMode>
     <RouterProvider router={router} />
  </React.StrictMode>
);
