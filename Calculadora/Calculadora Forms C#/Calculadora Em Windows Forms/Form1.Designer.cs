namespace Calculadora_Em_Windows_Forms
{
    partial class Form1
    {
        /// <summary>
        /// Variável de designer necessária.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpar os recursos que estão sendo usados.
        /// </summary>
        /// <param name="disposing">true se for necessário descartar os recursos gerenciados; caso contrário, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código gerado pelo Windows Form Designer

        /// <summary>
        /// Método necessário para suporte ao Designer - não modifique 
        /// o conteúdo deste método com o editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.numero1 = new System.Windows.Forms.TextBox();
            this.numero2 = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.AddButton = new System.Windows.Forms.Button();
            this.SubtractButton = new System.Windows.Forms.Button();
            this.SplitButton = new System.Windows.Forms.Button();
            this.MultiplicaButton = new System.Windows.Forms.Button();
            this.Result = new System.Windows.Forms.Label();
            this.PowButton = new System.Windows.Forms.Button();
            this.RootButton = new System.Windows.Forms.Button();
            this.SinButton = new System.Windows.Forms.Button();
            this.CosButton = new System.Windows.Forms.Button();
            this.TgButton = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // numero1
            // 
            this.numero1.Location = new System.Drawing.Point(43, 80);
            this.numero1.Name = "numero1";
            this.numero1.Size = new System.Drawing.Size(116, 20);
            this.numero1.TabIndex = 0;
            this.numero1.TextChanged += new System.EventHandler(this.Numero1_TextChanged);
            // 
            // numero2
            // 
            this.numero2.Location = new System.Drawing.Point(291, 80);
            this.numero2.Name = "numero2";
            this.numero2.Size = new System.Drawing.Size(116, 20);
            this.numero2.TabIndex = 1;
            this.numero2.TextChanged += new System.EventHandler(this.Numero2_TextChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(40, 64);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(82, 13);
            this.label1.TabIndex = 2;
            this.label1.Text = "Primeiro número";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(288, 64);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(88, 13);
            this.label2.TabIndex = 3;
            this.label2.Text = "Segundo número";
            // 
            // AddButton
            // 
            this.AddButton.Location = new System.Drawing.Point(183, 80);
            this.AddButton.Name = "AddButton";
            this.AddButton.Size = new System.Drawing.Size(75, 23);
            this.AddButton.TabIndex = 4;
            this.AddButton.Text = "Somar";
            this.AddButton.UseVisualStyleBackColor = true;
            this.AddButton.Click += new System.EventHandler(this.AddButton_Click);
            // 
            // SubtractButton
            // 
            this.SubtractButton.Location = new System.Drawing.Point(183, 109);
            this.SubtractButton.Name = "SubtractButton";
            this.SubtractButton.Size = new System.Drawing.Size(75, 23);
            this.SubtractButton.TabIndex = 5;
            this.SubtractButton.Text = "Subtrair";
            this.SubtractButton.UseVisualStyleBackColor = true;
            this.SubtractButton.Click += new System.EventHandler(this.SubtractButton_Click);
            // 
            // SplitButton
            // 
            this.SplitButton.Location = new System.Drawing.Point(183, 138);
            this.SplitButton.Name = "SplitButton";
            this.SplitButton.Size = new System.Drawing.Size(75, 23);
            this.SplitButton.TabIndex = 6;
            this.SplitButton.Text = "Dividir";
            this.SplitButton.UseVisualStyleBackColor = true;
            this.SplitButton.Click += new System.EventHandler(this.SplitButton_Click);
            // 
            // MultiplicaButton
            // 
            this.MultiplicaButton.Location = new System.Drawing.Point(183, 167);
            this.MultiplicaButton.Name = "MultiplicaButton";
            this.MultiplicaButton.Size = new System.Drawing.Size(75, 23);
            this.MultiplicaButton.TabIndex = 7;
            this.MultiplicaButton.Text = "Multiplicar";
            this.MultiplicaButton.UseVisualStyleBackColor = true;
            this.MultiplicaButton.Click += new System.EventHandler(this.MultiplicaButton_Click);
            // 
            // Result
            // 
            this.Result.AutoSize = true;
            this.Result.Location = new System.Drawing.Point(193, 347);
            this.Result.Name = "Result";
            this.Result.Size = new System.Drawing.Size(55, 13);
            this.Result.TabIndex = 8;
            this.Result.Text = "Resultado";
            // 
            // PowButton
            // 
            this.PowButton.Location = new System.Drawing.Point(183, 196);
            this.PowButton.Name = "PowButton";
            this.PowButton.Size = new System.Drawing.Size(75, 23);
            this.PowButton.TabIndex = 9;
            this.PowButton.Text = "Potencia";
            this.PowButton.UseVisualStyleBackColor = true;
            this.PowButton.Click += new System.EventHandler(this.PowButton_Click);
            // 
            // RootButton
            // 
            this.RootButton.Location = new System.Drawing.Point(183, 225);
            this.RootButton.Name = "RootButton";
            this.RootButton.Size = new System.Drawing.Size(75, 23);
            this.RootButton.TabIndex = 10;
            this.RootButton.Text = "Raiz";
            this.RootButton.UseVisualStyleBackColor = true;
            this.RootButton.Click += new System.EventHandler(this.RootButton_Click);
            // 
            // SinButton
            // 
            this.SinButton.Location = new System.Drawing.Point(183, 254);
            this.SinButton.Name = "SinButton";
            this.SinButton.Size = new System.Drawing.Size(75, 23);
            this.SinButton.TabIndex = 11;
            this.SinButton.Text = "Sin";
            this.SinButton.UseVisualStyleBackColor = true;
            this.SinButton.Click += new System.EventHandler(this.SinButton_Click);
            // 
            // CosButton
            // 
            this.CosButton.Location = new System.Drawing.Point(183, 283);
            this.CosButton.Name = "CosButton";
            this.CosButton.Size = new System.Drawing.Size(75, 23);
            this.CosButton.TabIndex = 12;
            this.CosButton.Text = "Cos";
            this.CosButton.UseVisualStyleBackColor = true;
            this.CosButton.Click += new System.EventHandler(this.CosButton_Click);
            // 
            // TgButton
            // 
            this.TgButton.Location = new System.Drawing.Point(183, 312);
            this.TgButton.Name = "TgButton";
            this.TgButton.Size = new System.Drawing.Size(75, 23);
            this.TgButton.TabIndex = 13;
            this.TgButton.Text = "Tg";
            this.TgButton.UseVisualStyleBackColor = true;
            this.TgButton.Click += new System.EventHandler(this.TgButton_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(457, 426);
            this.Controls.Add(this.TgButton);
            this.Controls.Add(this.CosButton);
            this.Controls.Add(this.SinButton);
            this.Controls.Add(this.RootButton);
            this.Controls.Add(this.PowButton);
            this.Controls.Add(this.Result);
            this.Controls.Add(this.MultiplicaButton);
            this.Controls.Add(this.SplitButton);
            this.Controls.Add(this.SubtractButton);
            this.Controls.Add(this.AddButton);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.numero2);
            this.Controls.Add(this.numero1);
            this.Name = "Form1";
            this.Text = "Calculadora";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox numero1;
        private System.Windows.Forms.TextBox numero2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button AddButton;
        private System.Windows.Forms.Button SubtractButton;
        private System.Windows.Forms.Button SplitButton;
        private System.Windows.Forms.Button MultiplicaButton;
        private System.Windows.Forms.Label Result;
        private System.Windows.Forms.Button PowButton;
        private System.Windows.Forms.Button RootButton;
        private System.Windows.Forms.Button SinButton;
        private System.Windows.Forms.Button CosButton;
        private System.Windows.Forms.Button TgButton;
    }
}

