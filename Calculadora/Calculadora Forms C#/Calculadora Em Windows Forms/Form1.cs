using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Calculadora_Em_Windows_Forms
{
    public partial class Form1 : Form
    {
        double num1, num2;
        public Form1()
        {
            InitializeComponent();
        }

        private void AddButton_Click(object sender, EventArgs e)
        {
            num1 = double.Parse(numero1.Text);
            num2 = double.Parse(numero2.Text);

            Result.Visible = true;
            Result.Text = (num1 + num2).ToString();
        }

        private void SubtractButton_Click(object sender, EventArgs e)
        {
            num1 = double.Parse(numero1.Text);
            num2 = double.Parse(numero2.Text);

            Result.Visible = true;
            Result.Text = (num1 - num2).ToString();
        }

        private void SplitButton_Click(object sender, EventArgs e)
        {
            num1 = double.Parse(numero1.Text);
            num2 = double.Parse(numero2.Text);

            Result.Visible = true;
            Result.Text = (num1 / num2).ToString();
        }

        private void MultiplicaButton_Click(object sender, EventArgs e)
        {
            num1 = double.Parse(numero1.Text);
            num2 = double.Parse(numero2.Text);

            Result.Visible = true;
            Result.Text = (num1 * num2).ToString();
        }

        private void Numero1_TextChanged(object sender, EventArgs e)
        {
            Result.Visible = false;
        }

        private void Numero2_TextChanged(object sender, EventArgs e)
        {
            Result.Visible = false;
        }

        private void PowButton_Click(object sender, EventArgs e)
        {
            num1 = double.Parse(numero1.Text);
            num2 = double.Parse(numero2.Text);

            Result.Visible = true;
            Result.Text = (Math.Pow(num1, num2)).ToString();
        }

        private void RootButton_Click(object sender, EventArgs e)
        {
            num1 = double.Parse(numero1.Text);
            num2 = double.Parse(numero2.Text);

            Result.Visible = true;
            Result.Text = (Math.Pow(num1, (1 / num2))).ToString();
        }

        private void SinButton_Click(object sender, EventArgs e)
        {
            num1 = double.Parse(numero1.Text);

            Result.Visible = true;
            Result.Text = (Math.Sin(num1)).ToString();
        }

        private void CosButton_Click(object sender, EventArgs e)
        {
            num1 = double.Parse(numero1.Text);

            Result.Visible = true;
            Result.Text = (Math.Cos(num1)).ToString();
        }

        private void TgButton_Click(object sender, EventArgs e)
        {
            num1 = double.Parse(numero1.Text);

            Result.Visible = true;
            Result.Text = (Math.Tan(num1)).ToString();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            Result.Visible = false;
        }
    }
}
