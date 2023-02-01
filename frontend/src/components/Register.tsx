import React from 'react'
import { useForm } from "react-hook-form";

function Register() {
  const { register, handleSubmit } = useForm();
  const onSubmit = (data:any) => console.log(data);
  return (
    <form onSubmit={handleSubmit(onSubmit)}>
    <label>Full Name </label>
    <input {...register("fullName")} />
    <button type="submit">Submit</button>
  </form>
  )
}

export default Register