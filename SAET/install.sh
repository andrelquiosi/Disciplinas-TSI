sudo apt update

# pip3
sudo apt install -y python3-pip

#tk and idle
sudo apt install -y python3-tk idle3

#virtualenv and virtualenvwrapper installation
sudo pip install -y virtualenv virtualenvwrapper
sudo rm -rf ~/.cache/pip

# virtualenv and virtualenvwrapper conf in ~/.bashrc
echo 'export WORKON_HOME=$HOME/.local/bin/.virtualenvs'  >> ~/.bashrc
echo 'export VIRTUALENVWRAPPER_PYTHON=/usr/bin/python3'  >> ~/.bashrc
echo 'export VIRTUALENVWRAPPER_VIRTUALENV=$HOME/.local/bin/virtualenv'  >> ~/.bashrc
echo 'source $HOME/.local/bin/virtualenvwrapper.sh'  >> ~/.bashrc

cd ~
mkdir curso

mkvirtualenv curso

#workon curso
