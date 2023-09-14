import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
/*import dotenv from 'dotenv'*/

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
}
/*
export default defineConfig(({
  plugins: [react()], mode }) => {
  // Cargar las variables de entorno según el modo
  const env = dotenv.config({
    path: `.env.${mode}`,
  }).parsed,

  // Convertir las variables de entorno en un objeto
  const envKeys = Object.keys(env).reduce((acc, key) => {
    acc[`import.meta.env.${key}`] = JSON.stringify(env[key]);
    return acc;
  }, {}),

  return: {
    define: envKeys,
  },
});*/
)
